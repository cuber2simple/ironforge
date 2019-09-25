package org.ironforge.bo;

import lombok.Data;
import lombok.ToString;
import org.ironforge.utils.MaskUtils;

@Data
@ToString
public class InvisibleCardBO {

    private String cardNo;

    private String cvv;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    @Override
    public String toString() {
        return "InvisibleCardBO{"
                + "cardNo='"
                + MaskUtils.pre6suff4(cardNo)
                + '\''
                + ", cvv='"
                + MaskUtils.fullMask(cvv)
                + '\''
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + ", email='"
                + email
                + '\''
                + ", mobile='"
                + MaskUtils.suffix4(mobile)
                + '\''
                + '}';
    }
}
