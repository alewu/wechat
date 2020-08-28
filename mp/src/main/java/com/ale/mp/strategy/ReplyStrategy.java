package com.ale.mp.strategy;


/**
 * The interface Reply strategy.
 *
 * @author alewu
 * @date 2020 /8/28
 */
public interface ReplyStrategy {
    /**
     * Handle.
     *
     * @param appId the appId
     */
    void handle(String appId);
}
