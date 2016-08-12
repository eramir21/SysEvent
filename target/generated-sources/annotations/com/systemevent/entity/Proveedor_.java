package com.systemevent.entity;

import com.systemevent.entity.Estado;
import com.systemevent.entity.Municipio;
import com.systemevent.entity.Pais;
import com.systemevent.entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T14:18:02")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Character> estado;
    public static volatile SingularAttribute<Proveedor, Integer> codigoProveedor;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile SingularAttribute<Proveedor, Estado> codigoEstado;
    public static volatile CollectionAttribute<Proveedor, Producto> productoCollection;
    public static volatile SingularAttribute<Proveedor, String> telefonoLocal;
    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, Municipio> codigoMunicipio;
    public static volatile SingularAttribute<Proveedor, String> rif;
    public static volatile SingularAttribute<Proveedor, String> email;
    public static volatile SingularAttribute<Proveedor, String> telefonoFijo;
    public static volatile SingularAttribute<Proveedor, Pais> codigoPais;

}