package com.systemevent.entity;

import com.systemevent.entity.Evento;
import com.systemevent.entity.Producto;
import com.systemevent.entity.ProductoEventoPK;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T14:18:02")
@StaticMetamodel(ProductoEvento.class)
public class ProductoEvento_ { 

    public static volatile SingularAttribute<ProductoEvento, ProductoEventoPK> productoEventoPK;
    public static volatile SingularAttribute<ProductoEvento, Evento> evento;
    public static volatile SingularAttribute<ProductoEvento, BigDecimal> monto;
    public static volatile SingularAttribute<ProductoEvento, Integer> cantidad;
    public static volatile SingularAttribute<ProductoEvento, Producto> producto;

}