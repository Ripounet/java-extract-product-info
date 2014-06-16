package fr.deleplace.valentin.extraction;

import org.jsoup.nodes.Document;

interface FieldExtractor<T> {
	  T extract(Document doc);
  }