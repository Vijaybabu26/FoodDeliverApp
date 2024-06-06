import img from '../Component/Images/Footer.jpg';

const Footer = () => {
    return (
        <>
        <div className="footer">
            <h1>For Better Experience,Download </h1>
            <h1>The Food Delivery App Now</h1>
            <img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto/portal/m/play_store.png"/>
            <img src="https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto/portal/m/app_store.png"/>
        </div>
        <div className="Details">
            <img src={img}/>
            <ul>
                <h4>We Deliver To</h4>
                <li>Banglore</li>
                <li>Hyderbad</li>
                <li>Gurgonom</li>
                <li>Delhi</li>
                <li>Mumbai</li>
                <li>Pune</li>
            </ul>
            <ul>
            <h4>Contact us</h4>
            <li>Help & Support</li>
            <li>Partner with us</li>
            <li>Ride with us</li>
            </ul>
            <div className="aboutus">
            
            <li>About Us</li>
            <li>Log Out</li>
            </div>   
        </div>
        </>
    );
}
export default Footer;