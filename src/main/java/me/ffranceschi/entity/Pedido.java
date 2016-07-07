package me.ffranceschi.entity;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by fernando on 7/6/16.
 */
@Entity
public class Pedido implements Serializable, Formattable {

    @Id
    @GeneratedValue
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Basic
    @Column(name = "de_pedido")
    private String dePedido;

    @ElementCollection
    private List<PedidoItem> itens = Lists.newLinkedList();

    public List<PedidoItem> getItens2() {
        return ImmutableList.copyOf(itens);
    }

    public void add(PedidoItem item) {
        checkNotNull(item);
        if (!itens.contains(item)) {
            itens.add(item);
        }
    }

    public Map<Integer, PedidoItem> getItens() {
        return itens.stream().collect(Collectors.toMap()); // fazer imutavel
    }


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
        return dePedido != null ? dePedido.equals(pedido.dePedido) : pedido.dePedido == null;

    }

    @Override
    public int hashCode() {
        int result = idPedido != null ? idPedido.hashCode() : 0;
        result = 31 * result + (dePedido != null ? dePedido.hashCode() : 0);
        return result;
    }

    public void formatTo(Formatter formatter, int flags, int width, int precision) {
//        getItens().values().stream().forEach();
    }
}
