import React from 'react'
import { useNavigate } from 'react-router-dom';
import ProductService from '../Services/ProductService';

export default function AddProduct() {
    const navigate = useNavigate();

    //Setting minimum date
    var dtToday = new Date();
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    var minDate = year + '-' + month + '-' + day;

    async function addProduct(event) {
        event.preventDefault();
        const newProduct = {
            "productName": document.getElementById("productName").value,
            "shortDescription": document.getElementById("shortDescription").value,
            "detailedDescription": document.getElementById("detailedDescription").value,
            "category": document.getElementById("itemCategory").value,
            "startingPrice": document.getElementById("startingPrice").value,
            "bidEndDate": document.getElementById("bidEndDate").value,
            "firstName": document.getElementById("firstName").value,
            "lastName": document.getElementById("lastName").value,
            "address": document.getElementById("address").value,
            "city": document.getElementById("city").value,
            "state": document.getElementById("state").value,
            "pin": document.getElementById("pincode").value,
            "phone": document.getElementById("phoneNumber").value,
            "email": document.getElementById("email").value
        }
        console.log(newProduct);

        var response = await ProductService.addProduct(newProduct)
        console.log(response);

        navigate("/")
    }
    function goToProduct() {
        navigate("/product")
    }
    return (
        <div className='addProductContainer'>
            <form onSubmit={addProduct}>
                <h4 id='sellerHeader'>Seller Details</h4>
                <div className='sellerForm'>
                    <div className='leftDiv'>
                        <div className='sellerDetails'>
                            <label>Enter First Name:</label>
                            <input className='inputFields' type="text" name="firstName" id="firstName" placeholder='Type Here...' minLength={5} maxLength={30} required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Enter your City:</label>
                            <input className='inputFields' type="text" name="city" id="city" placeholder='Type Here...' required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Contact Number:</label>
                            <input className='inputFields' type="number" name="phoneNumber" id="phoneNumber" placeholder='Type Here...' minLength={10} maxLength={10} required/>
                        </div>
                    </div>
                    <div className='centerDiv'>
                        <div className='sellerDetails'>
                            <label>Enter Last Name:</label>
                            <input className='inputFields' type="text" name="lastName" id="lastName" placeholder='Type Here...' minLength={3} maxLength={25} required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Enter your State:</label>
                            <input className='inputFields' type="text" name="state" id="state" placeholder='Type Here...' required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Enter your Email:</label>
                            <input className='inputFields' type="email" name="email" id="email" placeholder='Type Here...' required/>
                        </div>
                    </div>
                    <div className='rightDiv'>
                        <div className='sellerDetails'>
                            <label>Enter your Address:</label>
                            <input className='inputFields' type="text" name="address" id="address" placeholder='Type Here...' required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Enter your Pincode:</label>
                            <input className='inputFields' type="text" name="pincode" id="pincode" placeholder='Type Here...' required/>
                        </div>
                    </div>
                </div>
                <h4 id='sellerHeader'>Product Details</h4>
                <div className='sellerForm'>
                    <div className='leftDiv'>
                        <div className='sellerDetails'>
                            <label>Enter Product Name:</label>
                            <input className='inputFields' type="text" name="productName" id="productName" placeholder='Type Here...' minLength={5} maxLength={30} required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Select the Category:</label>
                            <select className='inputFields' name="category" id="itemCategory" required>
                                <option value="">Please choose an option</option>
                                <option value="Painting">Painting</option>
                                <option value="Sculptor">Sculptor</option>
                                <option value="Ornament">Ornament</option>
                            </select>
                        </div>
                    </div>
                    <div className='centerDiv'>
                        <div className='sellerDetails'>
                            <label>Short Description:</label>
                            <input className='inputFields' type="text" name="shortDescription" id="shortDescription" placeholder='Type Here...' required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Enter Starting Price:</label>
                            <input className='inputFields' type="number" name="startingPrice" id="startingPrice" placeholder='Type Here...' required/>
                        </div>
                        <div className='sellerDetails'>
                            <button id='sellerSubmitButton1' onClick={goToProduct}>Go Back</button>
                            <button id='sellerSubmitButton2'>Add Product</button>
                        </div>
                    </div>
                    <div className='rightDiv'>
                        <div className='sellerDetails'>
                            <label>Long Description:</label>
                            <input className='inputFields' type="text" name="longDescription" id="detailedDescription" placeholder='Type Here...' required/>
                        </div>
                        <div className='sellerDetails'>
                            <label>Select End Date:</label>
                            <input className='inputFields' type="date" name="bidEndDate" id="bidEndDate" placeholder='Type Here...' required min={minDate}/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    )
}
