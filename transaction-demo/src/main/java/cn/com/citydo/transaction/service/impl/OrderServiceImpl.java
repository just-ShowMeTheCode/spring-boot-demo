package cn.com.citydo.transaction.service.impl;

import cn.com.citydo.transaction.model.Order;
import cn.com.citydo.transaction.dao.OrderMapper;
import cn.com.citydo.transaction.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.com.citydo.transaction.service.ScoreService;
import cn.com.citydo.transaction.vo.SaveOrderVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fumj
 * @since 2019-07-26
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final ScoreService scoreService;

    public OrderServiceImpl(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public ResponseEntity saveOrder(SaveOrderVo saveOrderVo) {

        return ResponseEntity.ok("save success");
    }
}
