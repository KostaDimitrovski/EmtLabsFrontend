import axios from '../custom-axios/axios';

const shopService = {
    fetchCategories: () => {
        return axios.get("/categories/list");
    },
    fetchBooks: () => {
        return axios.get("/books/list");
    },
    fetchAuthors: () => {
        return axios.get("/authors/list");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },

    addBook: (name,category,authorId,availableCopies) => {
        return axios.post("/books/add", {
                "name" : name,
                "category" : category,
                "authorId" : authorId,
                "availableCopies" : availableCopies

        })
    },
    markBook: (id) => {
        return axios.post(`/books/mark/${id}`)
            .catch((error) => {
                if (error.response && error.response.status === 404) {
                   alert("Sorry no more available books:(")
                }
            });
    },

    editBook: (id,name,category,authorId,availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "authorId" : authorId,
            "availableCopies" : availableCopies
        })
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`)
    }
}

export default shopService;