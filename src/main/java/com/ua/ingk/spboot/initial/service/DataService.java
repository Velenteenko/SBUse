package com.ua.ingk.spboot.initial.service;

import java.util.Set;

public interface DataService {

	boolean persist(String problem);

	Set<String> getRandomData();
}
