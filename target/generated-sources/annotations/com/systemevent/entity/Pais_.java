package com.systemevent.entity;

import com.systemevent.entity.Cliente;
import com.systemevent.entity.Estado;
import com.systemevent.entity.Evento;
import com.systemevent.entity.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T16:25:54")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> codigoInternacional;
    public static volatile CollectionAttribute<Pais, Estado> estadoCollection;
    public static volatile CollectionAttribute<Pais, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<Pais, String> nombre;
    public static volatile SingularAttribute<Pais, Integer> codigoPais;
    public static volatile CollectionAttribute<Pais, Cliente> clienteCollection;
    public static volatile CollectionAttribute<Pais, Evento> eventoCollection;

}