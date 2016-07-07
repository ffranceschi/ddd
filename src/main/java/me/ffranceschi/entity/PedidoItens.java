package me.ffranceschi.entity;

import com.google.common.collect.ForwardingMap;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by fernando on 7/7/16.
 */
public class PedidoItens extends ForwardingMap<Integer, PedidoItem> {

    private final Map<Integer, PedidoItem> delegate;

    @Override
    protected Map<Integer, PedidoItem> delegate() {
        return delegate;
    }

    public PedidoItens(Map<Integer, PedidoItem> delegate) {
        this.delegate = delegate;
    }

    public BigDecimal getQuantidade() {
       return delegate.values().stream().map((PedidoItem i) ->i.getNrQuantidade()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
