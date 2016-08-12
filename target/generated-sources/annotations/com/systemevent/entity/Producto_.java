package com.systemevent.entity;

import com.systemevent.entity.ProductoEvento;
import com.systemevent.entity.Proveedor;
import com.systemevent.entity.TipoEvento;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T16:25:54")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, BigDecimal> precioUnitario;
    public static volatile CollectionAttribute<Producto, TipoEvento> tipoEventoCollection;
    public static volatile SingularAttribute<Producto, Proveedor> codigoProveedor;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, Integer> codigoProducto;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile CollectionAttribute<Producto, ProductoEvento> productoEventoCollection;

}