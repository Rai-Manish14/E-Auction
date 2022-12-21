import { useState } from "react"
import bidContext from "./bidContext"

const BidState = (props) => {
    const b = []

    const [state, setState] = useState(b)

    // const updateBidData = (a, b, c, d, e, f, g, h, i, j) => {
    const updateBidData = (a) => {
        setState(a)
    }

    return (
        <bidContext.Provider value={{ state, updateBidData }}>
            {props.children}
        </bidContext.Provider>
    )
}

export default BidState