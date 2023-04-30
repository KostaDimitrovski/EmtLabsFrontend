import React from "react";
import { useNavigate } from 'react-router-dom';

const BookAdd = (props) => {
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        category: "HISTORY",
        authorId: 1,
        availableCopies: 0
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        updateFormData(prevState => ({ ...prevState, [name]: value }));
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const category = formData.category;
        const authorId = formData.authorId;
        const availableCopies = formData.availableCopies;

        props.onAddBook(name, category, authorId, availableCopies);
        navigate('/books');
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Product name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter book name"
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="availableCopies">Quantity</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder="availableCopies"
                               required
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) =>
                                <option key={term} value={term}>{term}</option>
                            )}
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Author</label>
                        <select name="authorId" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) => (
                                <option key={term.id} value={term.id}>
                                    {term.name}
                                </option>
                            ))}
                        </select>
                    </div>

                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookAdd;
