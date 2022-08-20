package com.cosium.sandip;

import java.util.Map;

public interface RowUnmapper<T> {
	Map<String, Object> mapColumns(T t);
}

