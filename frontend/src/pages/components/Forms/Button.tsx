type ButtonProps = {
    title: string;
}

function Button({title}: ButtonProps) {
    return(
        <button className="bg-orange-500 hover:bg-orange-700 text-black font-bold py-2 px-4 rounded">{title}</button>

    )
}

export default Button;