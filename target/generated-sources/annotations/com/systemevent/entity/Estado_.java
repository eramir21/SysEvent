package com.systemevent.entity;

import com.systemevent.entity.Cliente;
import com.systemevent.entity.Evento;
import com.systemevent.entity.Municipio;
import com.systemevent.entity.Pais;
import com.systemevent.entity.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T16:25:54")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile CollectionAttribute<Estado, Municipio> municipioCollection;
    public static volatile CollectionAttribute<Estado, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<Estado, Integer> codigoEstado;
    public static volatile SingularAttribute<Estado, String> nombre;
    public static volatile CollectionAttribute<Estado, Cliente> clienteCollection;
    public static volatile SingularAttribute<Estado, Pais> codigoPais;
    public static volatile CollectionAttribute<Estado, Evento> eventoCollection;

}