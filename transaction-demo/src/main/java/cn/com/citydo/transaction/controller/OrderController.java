package cn.com.citydo.transaction.controller;


import cn.com.citydo.transaction.service.OrderService;
import cn.com.citydo.transaction.vo.SaveOrderVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fumj
 * @since 2019-07-26
 */
@RestController
@RequestMapping("/transaction/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity saveOrder(@RequestBody SaveOrderVo saveOrderVo){
        return orderService.saveOrder(saveOrderVo);
    }
}

