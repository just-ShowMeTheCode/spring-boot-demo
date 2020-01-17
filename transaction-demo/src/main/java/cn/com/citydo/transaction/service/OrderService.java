package cn.com.citydo.transaction.service;

import cn.com.citydo.transaction.model.Order;
import cn.com.citydo.transaction.vo.SaveOrderVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fumj
 * @since 2019-07-26
 */
public interface OrderService extends IService<Order> {

    ResponseEntity saveOrder(SaveOrderVo saveOrderVo);
}
