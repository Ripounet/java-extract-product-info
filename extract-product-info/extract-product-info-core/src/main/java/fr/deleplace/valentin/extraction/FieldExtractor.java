package fr.deleplace.valentin.extraction;


import org.jsoup.nodes.Document;

/**
 * An Extractor takes a JSoup Document as input and performs
 * a search for a product field value.
 * 
 * @author valentindeleplace
 *
 * @param <T> the type of the field value.
 */
interface FieldExtractor<T> {
	T extract(Document doc);
}