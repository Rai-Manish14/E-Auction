import axios from "axios";

const addProduct = "http://localhost:9001/seller/addProduct"
const searchProduct = "http://localhost:9001/seller/getProductByProductName/"
const getAllBids = "http://localhost:9001/seller/show-bids/"
const deleteProduct = "http://localhost:9001/seller/deleteProduct/"

class ProductService {
    //for adding product
    async addProduct(product) {
        try {
            var productRes = await axios.post(addProduct, product).then(response => {
                return response
            })
        } catch (error) {
            product = ""
        }
        finally {
            return productRes;
        }
    }

    //For searching product
    async searchProduct(productName) {
        try {
            var product = await axios.get(searchProduct + productName).then(response => {
                return response
            })
        } catch (error) {
            alert(error.response.data)
            return null
        }
        finally {
            return product
        }
    }

    //For getting all bids
    async getAllBids(productId) {
        try {
            var product = await axios.get(getAllBids + productId).then(response => {
                return response
            })
        } catch (error) {
            alert(error.response.data)
            return null
        }
        finally {
            return product
        }
    }

    //For deleting the product
    async deleteProduct(productId) {
        try {
            var product = await axios.delete(deleteProduct + productId).then(response => {
                return response
            })
        } catch (error) {
            alert(error.response.data)
            return null
        }
        finally {
            return product
        }
    }
}

export default new ProductService();