package com.cosium.sandip.sql;


import com.cosium.sandip.TableDescription;
import org.springframework.data.domain.Pageable;

/**
 * Author: tom
 */
public class MssqlSqlGenerator extends AbstractMssqlSqlGenerator {
	public MssqlSqlGenerator() {
	}

	public MssqlSqlGenerator(String allColumnsClause) {
		super(allColumnsClause);
	}


	@Override
	public String selectAll(TableDescription table, Pageable page) {
		return SQL99Helper.generateSelectAllWithPagination(table, page, this);
	}
}
