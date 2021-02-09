package com.videojuegos.model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-08T22:48:25")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ { 

    public static volatile SingularAttribute<Auditoria, Date> fecha_aud;
    public static volatile SingularAttribute<Auditoria, String> operacion_aud;
    public static volatile SingularAttribute<Auditoria, String> activar_aud;
    public static volatile SingularAttribute<Auditoria, Integer> id_aud;
    public static volatile SingularAttribute<Auditoria, String> usuario_aud;
    public static volatile SingularAttribute<Auditoria, String> trigger_aud;
    public static volatile SingularAttribute<Auditoria, String> esquema_aud;
    public static volatile SingularAttribute<Auditoria, String> tabla_aud;
    public static volatile SingularAttribute<Auditoria, String> valoranterior_aud;
    public static volatile SingularAttribute<Auditoria, String> valornuevo_aud;

}