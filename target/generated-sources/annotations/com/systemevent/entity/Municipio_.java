package com.systemevent.entity;

import com.systemevent.entity.Cliente;
import com.systemevent.entity.Estado;
import com.systemevent.entity.Evento;
import com.systemevent.entity.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T14:18:02")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile CollectionAttribute<Municipio, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<Municipio, Estado> codigoEstado;
    public static volatile SingularAttribute<Municipio, Integer> codigoMunicipio;
    public static volatile SingularAttribute<Municipio, String> nombre;
    public static volatile CollectionAttribute<Municipio, Cliente> clienteCollection;
    public static volatile CollectionAttribute<Municipio, Evento> eventoCollection;

}