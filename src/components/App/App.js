import './App.css';
import React, {Component} from "react";
import { Navigate  } from 'react-router-dom';
import Header from '../Header/header'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Categories from '../Categories/categories';
import Authors from '../Authors/authors';
import BookEdit from "../Books/BookEdit/bookEdit";
import BookAdd from '../Books/BookAdd/bookAdd'
import Books from '../Books/BookList/books';
import shopService from '../../repository/shopRepository';
import data from "bootstrap/js/src/dom/data";
class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            categories: [],
            books: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <Routes>
                    <Route path={"/categories"} exact element={<Categories categories={this.state.categories} />} />
                    <Route path={"/authors"} exact element={<Authors authors={this.state.authors} />} />
                    <Route path={"/books/add"}
                           exact element={<BookAdd categories={this.state.categories}
                                 authors={this.state.authors} onAddBook={this.addBook} /> } />
                    <Route path={"/books/edit/:id"}
                           exact element={<BookEdit categories={this.state.categories} authors={this.state.authors}
                                 onEditBook={this.editBook} book={this.state.selectedBook}/> } />
                    <Route path={"/books"} exact element={<Books books={this.state.books}
                                 onDelete={this.deleteBook} onEdit={this.getBook} onMark={this.markBook}/> } />
                    <Route path="/" element={<Navigate to="/books" />} />
                </Routes>
            </Router>
        );
    }


    componentDidMount() {
        this.loadCategories();
        this.loadBooks();
        this.loadAuthors();
    }
    loadCategories = () => {
        shopService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            })
    }
    loadBooks = () => {
        shopService.fetchBooks()
            .then(data => {
                this.setState({
                    books: data.data
                })
            })

    }
    loadAuthors= () => {
        shopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

    deleteBook= (id) => {
        shopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }
    addBook = (name,category,authorId,availableCopies) => {
        shopService.addBook(name,category,authorId,availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    getBook = (id) => {
        shopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }


    editBook = (id,name,category,authorId,availableCopies) => {
        shopService.editBook(id,name,category,authorId,availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    markBook = (id) => {
            shopService.markBook(id)
                .then(() => {
                    this.loadBooks();
                })


    }
}

export default App;