package com.nikospap.service.converters;

import java.util.List;

public interface IConverter<S, T> {

	T convert(S source, Class<T> targetClass);
	
	List<T> convertList(List<S> source, Class<T> targetClass);
}
