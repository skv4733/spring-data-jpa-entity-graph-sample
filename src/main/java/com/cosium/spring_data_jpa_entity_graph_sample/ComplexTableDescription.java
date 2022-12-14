package com.cosium.spring_data_jpa_entity_graph_sample;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Based on com.nurkiewicz.jdbcrepository.TableDescription, with a number of modifications.
 * 
 * @author woemler  https://github.com/nurkiewicz/spring-data-jdbc-repository
 */
public class ComplexTableDescription {
	
	private String tableName;
	private List<String> idColumns;
	private String selectClause;
	private String fromClause;
	private String groupByClause;

	public ComplexTableDescription(String tableName, List<String> idColumns,
			String selectClause, String fromClause, String groupByClause) {

		Assert.notNull(tableName);
		Assert.notNull(idColumns);
		Assert.notNull(selectClause);
		Assert.notNull(fromClause);
		Assert.notNull(groupByClause);
		
		this.tableName = tableName;
		this.idColumns = idColumns;
		this.selectClause = selectClause;
		this.fromClause = fromClause;
		this.groupByClause = groupByClause;

	}

	public ComplexTableDescription(String tableName, List<String> idColumns,
			String selectClause, String fromClause) {
		this(tableName, idColumns, selectClause, fromClause, "");
	}

	public ComplexTableDescription(String tableName, List<String> idColumns,
			String selectClause) {
		this(tableName, idColumns, selectClause, tableName, "");
	}

	public ComplexTableDescription(String tableName, List<String> idColumns) {
		this(tableName, idColumns, tableName+".*", tableName, "");
	}

	public ComplexTableDescription(String tableName) {
		this(tableName, Arrays.asList(new String[]{tableName+".id"}), tableName+".*", tableName, "");
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getIdColumns() {
		return idColumns;
	}

	public void setIdColumns(List<String> idColumns) {
		this.idColumns = idColumns;
	}

	public String getSelectClause() {
		return selectClause;
	}

	public void setSelectClause(String selectClause) {
		this.selectClause = selectClause;
	}

	public String getFromClause() {
		return fromClause;
	}

	public void setFromClause(String fromClause) {
		this.fromClause = fromClause;
	}

	public String getGroupByClause() {
		return groupByClause;
	}

	public void setGroupByClause(String groupByClause) {
		this.groupByClause = groupByClause;
	}
}
