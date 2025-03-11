import React from 'react';
import "../../index.css";

interface HeaderProps {
    title: string;
}

const Header: React.FC<HeaderProps> = ({ title }) => {
    const links = [
        { name: 'Profile', path: '/profile' },
        { name: 'All Games', path: '/games' }
    ];

    return (
        <header className="bg-orange-500 text-black p-4">
            <div className="container mx-auto flex justify-between items-center">
                <h1 className="text-xl font-bold">{title}</h1>
                <nav>
                    <ul className="flex space-x-4">
                        {links.map((link) => (
                            <li key={link.name}>
                                <a href={link.path} className="hover:underline">
                                    {link.name}
                                </a>
                            </li>
                        ))}
                    </ul>
                </nav>
            </div>
        </header>
    );
};

export default Header;
