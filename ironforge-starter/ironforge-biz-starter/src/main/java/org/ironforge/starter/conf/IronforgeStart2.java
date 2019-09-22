package org.ironforge.starter.conf;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@Slf4j
public class IronforgeStart2 {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Environment environment;

    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        log.debug("Starting HazelcastCacheManager");
        return new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance);
    }

    @Bean
    public HazelcastInstance hazelcastInstance() {
        String serverName = environment.getProperty("spring.application.name");
        HazelcastInstance hazelCastInstance = Hazelcast.getHazelcastInstanceByName(serverName);
        if (hazelCastInstance != null) {
            return hazelCastInstance;
        }
        Config config = new Config();
        config.setInstanceName(serverName);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().setPort(5701);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
        for (ServiceInstance instance : discoveryClient.getInstances(serverName)) {
            String clusterMember = instance.getHost() + ":5701";
            log.debug("Adding Hazelcast (prod) cluster member {}", clusterMember);
            config.getNetworkConfig().getJoin().getTcpIpConfig().addMember(clusterMember);
        }
        config.getMapConfigs().put("default", initializeDefaultMapConfig());

        // Full reference is available at: http://docs.hazelcast.org/docs/management-center/3.9/manual/html/Deploying_and_Starting.html
        config.setManagementCenterConfig(initializeDefaultManagementCenterConfig());
        config.getMapConfigs().put(environment.getProperty("hazelcast.domain-package"), initializeDomainMapConfig());
        return Hazelcast.newHazelcastInstance(config);
    }

    private MapConfig initializeDefaultMapConfig() {
        MapConfig mapConfig = new MapConfig();
        /*
        Number of backups. If 1 is set as the backup-count for example,
        then all entries of the map will be copied to another JVM for
        fail-safety. Valid numbers are 0 (no backup), 1, 2, 3.
        */
        mapConfig.setBackupCount(environment.getProperty("hazelcast.backup-count", Integer.class, 1));
        /*
        Valid values are:
        NONE (no eviction),
        LRU (Least Recently Used),
        LFU (Least Frequently Used).
        NONE is the default.
        */
        mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
        /*
        Maximum size of the map. When max size is reached,
        map is evicted based on the policy defined.
        Any integer between 0 and Integer.MAX_VALUE. 0 means
        Integer.MAX_VALUE. Default is 0.
        */
        mapConfig.setMaxSizeConfig(new MaxSizeConfig(0, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE));
        return mapConfig;
    }

    private ManagementCenterConfig initializeDefaultManagementCenterConfig() {
        ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig();
        managementCenterConfig.setEnabled(environment.getProperty("hazelcast.management-center.enabled", Boolean.class, false));
        managementCenterConfig.setUrl(environment.getProperty("hazelcast.management-center.url", String.class, "http://localhost:8180/mancenter"));
        managementCenterConfig.setUpdateInterval(environment.getProperty("hazelcast.management-center.update-interval", Integer.class, 3));
        return managementCenterConfig;
    }

    private MapConfig initializeDomainMapConfig() {
        MapConfig mapConfig = new MapConfig();
        mapConfig.setTimeToLiveSeconds(environment.getProperty("hazelcast.time-to-live-seconds", Integer.class, 3600));
        return mapConfig;
    }

}
