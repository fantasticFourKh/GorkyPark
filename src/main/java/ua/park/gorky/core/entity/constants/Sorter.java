/*
package ua.park.gorky.core.entity.constants;

import ua.park.gorky.db.entity.ext.CommentExt;
import ua.park.gorky.db.entity.ext.NewsExt;

import java.util.Comparator;

public class Sorter {

	// COMMENT count sorter
	public static final Comparator<NewsExt> SORT_BY_COMMENT = new Comparator<NewsExt>() {

		@Override
		public int compare(NewsExt o1, NewsExt o2) {
			return o1.getCountComment() - o2.getCountComment();
		}
	};

	public static final Comparator<NewsExt> SORT_BY_COMMENT_REVERSE = new Comparator<NewsExt>() {

		@Override
		public int compare(NewsExt o1, NewsExt o2) {
			return o2.getCountComment() - o1.getCountComment();
		}
	};

	// NEWS date sorter

	public static final Comparator<NewsExt> SORT_NEWS_BY_DATE = new Comparator<NewsExt>() {
		@Override
		public int compare(NewsExt o1, NewsExt o2) {
			return o2.getPostDate().compareTo(o1.getPostDate());
		}
	};

	public static final Comparator<NewsExt> SORT_NEWS_BY_DATE_REVERSE = new Comparator<NewsExt>() {
		@Override
		public int compare(NewsExt o1, NewsExt o2) {
			return o1.getPostDate().compareTo(o2.getPostDate());
		}
	};

	// COMMENT date sorter

	public static final Comparator<CommentExt> SORT_COMMENT_BY_DATE = new Comparator<CommentExt>() {
		@Override
		public int compare(CommentExt o1, CommentExt o2) {
			return (o2.getPostDate().compareTo(o1.getPostDate()));
		}
	};

	public static final Comparator<CommentExt> SORT_COMMENT_BY_DATE_REVERSE = new Comparator<CommentExt>() {
		@Override
		public int compare(CommentExt o1, CommentExt o2) {
			return (o2.getPostDate().compareTo(o1.getPostDate()));
		}
	};

}*/
