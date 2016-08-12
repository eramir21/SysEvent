package com.systemevent.entity;

import com.systemevent.entity.Evento;
import com.systemevent.entity.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T16:25:54")
@StaticMetamodel(TipoEvento.class)
public class TipoEvento_ { 

    public static volatile SingularAttribute<TipoEvento, String> descripcion;
    public static volatile CollectionAttribute<TipoEvento, Producto> productoCollection;
    public static volatile SingularAttribute<TipoEvento, Integer> codigoTipoEvento;
    public static volatile CollectionAttribute<TipoEvento, Evento> eventoCollection;

}