package com.alevel.service.impl;

import com.alevel.service.SearchItemService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.ArrayList;
import java.util.List;

//public class SearchItemServiceImpl implements SearchItemService {
//    @Override
//    public List<String> fetchSuggestions(String query) {
//        QueryBuilder queryBuilder = QueryBuilders
//                .wildcardQuery("name", query + "*");
//        Query searchQuery = new NativeSearchQueryBuilder()
//                .withFilter(queryBuilder)
//                .withPageable(PageRequest.of(0, 5))
//                .build();
//        SearchHits<ItemIndex> searchSuggestions =
//                elasticsearchOperations.search(searchQuery,
//                        BookIndex.class,
//                        IndexCoordinates.of(BOOK_INDEX));
//        final List<String> suggestions = new ArrayList<>();
//        searchSuggestions.getSearchHits().forEach(searchHit-> suggestions.add(searchHit.getContent().getName()));
//        return suggestions;
//    }
//}
