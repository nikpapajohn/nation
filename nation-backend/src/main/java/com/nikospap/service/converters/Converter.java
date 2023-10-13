package com.nikospap.service.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class Converter<S, T> implements IConverter<S, T> {

	@Autowired
	protected ModelMapper modelMapper;


	public T convert(S source, Class<T> targetClass) {
		if (source == null)
			return null;
		else
			return modelMapper.map(source, targetClass);
	}

	public List<T> convertList(List<S> source, Class<T> targetClass) {
		if (!CollectionUtils.isEmpty(source))
			return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
		else
			return new ArrayList<T>();
	}
}
