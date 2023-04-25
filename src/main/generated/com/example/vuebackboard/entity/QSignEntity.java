package com.example.vuebackboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSignEntity is a Querydsl query type for SignEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSignEntity extends EntityPathBase<SignEntity> {

    private static final long serialVersionUID = 63155719L;

    public static final QSignEntity signEntity = new QSignEntity("signEntity");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final StringPath userPw = createString("userPw");

    public QSignEntity(String variable) {
        super(SignEntity.class, forVariable(variable));
    }

    public QSignEntity(Path<? extends SignEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSignEntity(PathMetadata metadata) {
        super(SignEntity.class, metadata);
    }

}

