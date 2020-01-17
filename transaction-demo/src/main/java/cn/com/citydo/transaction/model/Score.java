package cn.com.citydo.transaction.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fumj
 * @since 2019-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_score")
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "score_id", type = IdType.AUTO)
    private Long scoreId;

    private Long orderId;

    /**
     * 获取的积分
     */
    private Integer score;


}
