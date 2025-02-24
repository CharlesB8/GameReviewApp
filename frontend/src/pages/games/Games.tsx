import Header from "../components/Header";
import {Outlet} from "react-router-dom";

function Games() {
    return (
        <div>
            <Header title="Games" />
            <Outlet />
        </div>
    )
}

export default Games;