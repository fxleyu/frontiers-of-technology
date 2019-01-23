package fx.leyu.notes.service.impl;

import fx.leyu.notes.service.BookService;

public class BookServiceImpl implements BookService {
    @Override
    public String getBook(String isbn) {
        return "作者: [美]李昂·戈拉伯（Leon Golub） / [美]杰伊·帕萨乔夫（Jay M.Pasachoff） \n" +
                "出版社: 北京联合出版公司\n" +
                "原作名: The Sun\n" +
                "译者: 青年天文教师连线 \n" +
                "出版年: 2019-1\n" +
                "定价: 259.00元\n" +
                "装帧: 精装\n" +
                "ISBN: 9787559627759";
    }
}
