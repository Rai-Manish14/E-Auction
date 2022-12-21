import axios from "axios";

const placeBid ="http://localhost:9002/buyer/place-bid"
const updateBid = "http://localhost:9002/buyer/update-bid/"

class BuyerService{
    // Place Bidding
    async placeBid(buyerData){
        try {
            var buyer = await axios.post(placeBid,buyerData).then(response=>{
                return response
            })
        } catch (error) {
            buyer=""
        }
        finally{
            return buyer;
        }
    }

    // Update Bidding
    async updateBid(productId, email, bidAmount){
        try {
            var buyer = await axios.post(updateBid+productId+"/"+email+"/"+bidAmount).then(response=>{
                return response
            })
        } catch (error) {
            alert(error.response.data)
            buyer=""
        }
        finally{
            return buyer;
        }
    }
}

export default new BuyerService;