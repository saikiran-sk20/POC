package Service;

import java.util.HashMap;
import java.util.Map;

import VO.BillingAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillingAccountService {

    @Autowired
    public static Map<Integer, BillingAccountVO> billingAccountVOMap = new HashMap<Integer,BillingAccountVO>();

    public BillingAccountVO getBillingAccountInfoByAccountID(Integer accountId) {
        return billingAccountVOMap.get(accountId);
    }

    public BillingAccountVO saveBillingAccountInfo(BillingAccountVO billingAccountVO) {
        if (billingAccountVO != null) {
            billingAccountVO.setCustomerID(billingAccountVOMap.size() + 1);
            billingAccountVOMap.put(billingAccountVO.getAccountID(), billingAccountVO);
        }
        return billingAccountVOMap.get(billingAccountVO.getAccountID());

    }

    public BillingAccountVO updateBillingAccountInfo(BillingAccountVO billingAccountVO) {
        billingAccountVOMap.put(billingAccountVO.getAccountID(), billingAccountVO);
        return billingAccountVOMap.get(billingAccountVO.getAccountID());
    }
}

