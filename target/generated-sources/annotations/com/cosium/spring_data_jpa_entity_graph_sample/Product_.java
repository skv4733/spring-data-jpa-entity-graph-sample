package com.cosium.spring_data_jpa_entity_graph_sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> name;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Brand> brand;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String BRAND = "brand";

}

