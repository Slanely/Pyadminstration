package com.Tools;

import java.io.Serializable;

public class T_with_G implements Serializable {
    private Long tanet_id;
    private Long stall_id;
    public T_with_G(){}
    public T_with_G(Long tid,Long sid)
    {
        this.stall_id=sid;
        this.tanet_id=tid;
    }
    public Long getTanet_id() {
        return tanet_id;
    }

    public void setTanet_id(Long tanet_id) {
        this.tanet_id = tanet_id;
    }

    public Long getStall_id() {
        return stall_id;
    }

    public void setStall_id(Long stall_id) {
        this.stall_id = stall_id;
    }
}
