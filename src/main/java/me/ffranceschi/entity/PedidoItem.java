package me.ffranceschi.entity;

import javax.persistence.*;

/**
 * Created by fernando on 7/6/16.
 */
@Entity
@Table(name = "pedido_item", schema = "t1", catalog = "teste")
public class PedidoItem {
    private Integer idPedidoItem;
    private Integer nrQuantidade;
    private Integer vlProduto;
    private Pedido pedidoByIdPedido;

    @Id
    @Column(name = "id_pedido_item")
    public Integer getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(Integer idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    @Basic
    @Column(name = "nr_quantidade")
    public Integer getNrQuantidade() {
        return nrQuantidade;
    }

    public void setNrQuantidade(Integer nrQuantidade) {
        this.nrQuantidade = nrQuantidade;
    }

    @Basic
    @Column(name = "vl_produto")
    public Integer getVlProduto() {
        return vlProduto;
    }

    public void setVlProduto(Integer vlProduto) {
        this.vlProduto = vlProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoItem that = (PedidoItem) o;

        if (idPedidoItem != null ? !idPedidoItem.equals(that.idPedidoItem) : that.idPedidoItem != null) return false;
        if (nrQuantidade != null ? !nrQuantidade.equals(that.nrQuantidade) : that.nrQuantidade != null) return false;
        if (vlProduto != null ? !vlProduto.equals(that.vlProduto) : that.vlProduto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedidoItem != null ? idPedidoItem.hashCode() : 0;
        result = 31 * result + (nrQuantidade != null ? nrQuantidade.hashCode() : 0);
        result = 31 * result + (vlProduto != null ? vlProduto.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    public Pedido getPedidoByIdPedido() {
        return pedidoByIdPedido;
    }

    public void setPedidoByIdPedido(Pedido pedidoByIdPedido) {
        this.pedidoByIdPedido = pedidoByIdPedido;
    }
}
