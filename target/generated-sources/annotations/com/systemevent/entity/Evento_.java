package com.systemevent.entity;

import com.systemevent.entity.Cliente;
import com.systemevent.entity.Estado;
import com.systemevent.entity.Municipio;
import com.systemevent.entity.Pais;
import com.systemevent.entity.ProductoEvento;
import com.systemevent.entity.TipoEvento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-12T16:25:54")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, String> descripcion;
    public static volatile SingularAttribute<Evento, Date> fecha;
    public static volatile SingularAttribute<Evento, String> ubicacion;
    public static volatile SingularAttribute<Evento, Character> estado;
    public static volatile SingularAttribute<Evento, Cliente> idCliente;
    public static volatile SingularAttribute<Evento, Integer> cantidadPersonas;
    public static volatile SingularAttribute<Evento, Integer> codigoEvento;
    public static volatile SingularAttribute<Evento, Estado> codigoEstado;
    public static volatile SingularAttribute<Evento, TipoEvento> codigoTipoEvento;
    public static volatile SingularAttribute<Evento, Municipio> codigoMunicipio;
    public static volatile CollectionAttribute<Evento, ProductoEvento> productoEventoCollection;
    public static volatile SingularAttribute<Evento, Pais> codigoPais;

}