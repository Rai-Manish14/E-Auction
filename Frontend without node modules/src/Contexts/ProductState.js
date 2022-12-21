import { useState } from "react"
import productContext from "./productContext"

const ProductState = (props) => {
    const p = {
        "productId": 0,
        "productName": "none",
        "shortDescription": "none",
        "detailedDescription": "none",
        "category": "none",
        "startingPrice": 0,
        "bidEndDate": "none",
        "firstName": "none",
        "lastName": "none",
        "address": "none",
        "city": "none",
        "state": "none",
        "pin": 0,
        "phone": 0,
        "email": "none"
    }

    const [state, setState] = useState(p)

    const updateProductData = (id,a,b,c,d,e,f,g,h,i,j,k,l,m,n) => {
        setState({
            "productId":id,
            "productName": a,
            "shortDescription": b,
            "detailedDescription": c,
            "category": d,
            "startingPrice": e,
            "bidEndDate": f,
            "firstName": g,
            "lastName": h,
            "address": i,
            "city": j,
            "state": k,
            "pin": l,
            "phone": m,
            "email": n 
        })
    }
    return(
        <productContext.Provider value={{state,updateProductData}}>
            {props.children}
        </productContext.Provider>
    )
}

export default ProductState;