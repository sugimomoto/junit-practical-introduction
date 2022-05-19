package org.example.category;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


// 別なテストスイートを作成して、ここからまとめて実行する
@RunWith(Categories.class)
@Categories.IncludeCategory(FastTest.class)
@Suite.SuiteClasses({FooTest.class})
public class CategorizedTest {
}
