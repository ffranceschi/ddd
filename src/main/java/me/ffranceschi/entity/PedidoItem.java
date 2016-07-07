package me.ffranceschi.entity;

import com.google.common.base.Preconditions;

import javax.persistence.*;
import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

@Embeddable
public class PedidoItem implements Serializable {

    private Integer idPedidoItem = 0;

    private Integer nrQuantidade = 0;

    private Integer vlProduto = 0;

    private PedidoItem(Integer idPedidoItem, Integer nrQuantidade, Integer vlProduto) {
        this.idPedidoItem = idPedidoItem;
        this.nrQuantidade = nrQuantidade;
        this.vlProduto = vlProduto;
    }

    public static PedidoItem of(Integer idPedidoItem, Integer nrQuantidade, Integer vlProduto) {
        checkNotNull(idPedidoItem);
        checkNotNull(nrQuantidade);
        checkNotNull(vlProduto);
        return new PedidoItem(idPedidoItem, nrQuantidade, vlProduto);
    }

    public Integer getIdPedidoItem() {
        return idPedidoItem;
    }

    public Integer getNrQuantidade() {
        return nrQuantidade;
    }

    public Integer getVlProduto() {
        return vlProduto;
    }

    public PedidoItem setIdPedidoItem(Integer idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
        return this;
    }

    public PedidoItem setNrQuantidade(Integer nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
        return this;
    }

    public PedidoItem setVlProduto(Integer vlProduto) {
        this.vlProduto = vlProduto;
        return this;
    }
}
