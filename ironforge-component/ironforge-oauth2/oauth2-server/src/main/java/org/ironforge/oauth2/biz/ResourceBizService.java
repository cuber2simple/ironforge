package org.ironforge.oauth2.biz;

import org.ironforge.biz.IronforgeBizService;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.persist.entity.TResource;

import java.util.List;

public interface ResourceBizService extends IronforgeBizService<Resource, TResource, Integer> {
    /**
     * 查找页面下的子元素
     *
     * @param resourceCode
     * @return
     */
    List<Resource> findSubElements(String resourceCode);

    /**
     * 重新设置页面的元素
     *
     * @param resourceCode
     * @param resourceCodes
     * @return
     */
    boolean resetSubElements(String resourceCode, List<String> resourceCodes);

}
