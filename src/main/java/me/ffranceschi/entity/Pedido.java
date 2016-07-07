package me.ffranceschi.entity;

import javax.persistence.*;

/**
 * Created by fernando on 7/6/16.
 */
@Entity
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Basic
    @Column(name = "de_pedido")
    private String dePedido;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getDePedido() {
        return dePedido;
    }

    public void setDePedido(String dePedido) {
        this.dePedido = dePedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        if (idPedido != null ? !idPedido.equals(pedido.idPedido) : pedido.idPedido != null) return false;
        if (dePedido != null ? !dePedido.equals(pedido.dePedido) : pedido.dePedido != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPedido != null ? idPedido.hashCode() : 0;
        result = 31 * result + (dePedido != null ? dePedido.hashCode() : 0);
        return result;
    }
}
