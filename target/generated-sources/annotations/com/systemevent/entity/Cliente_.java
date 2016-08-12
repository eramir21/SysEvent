package com.systemevent.entity;

import com.systemevent.entity.Estado;
import com.systemevent.entity.Evento;
import com.systemevent.entity.Municipio;
import com.systemevent.entity.Pais;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T16:25:54")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, Estado> codigoEstado;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, Municipio> codigoMunicipio;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile SingularAttribute<Cliente, String> rif;
    public static volatile SingularAttribute<Cliente, Pais> codigoPais;
    public static volatile CollectionAttribute<Cliente, Evento> eventoCollection;

}