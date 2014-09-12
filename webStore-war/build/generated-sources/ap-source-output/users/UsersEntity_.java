package users;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-05-07T16:30:45")
@StaticMetamodel(UsersEntity.class)
public class UsersEntity_ { 

    public static volatile SingularAttribute<UsersEntity, Long> id;
    public static volatile SingularAttribute<UsersEntity, String> permissionLevel;
    public static volatile SingularAttribute<UsersEntity, String> pseudo;
    public static volatile SingularAttribute<UsersEntity, String> password;

}