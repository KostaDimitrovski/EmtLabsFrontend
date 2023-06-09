import React from "react";

const authors = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"} >
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>

                        </tr>
                        </thead>
                        <tbody className={"catBody"}>
                        {props.authors.map((author) => {
                            return (
                                <tr>
                                    <td>{author.name}</td>
                                    <td>{author.surname}</td>
                                </tr>
                            )
                        })}

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default authors;