INSERT INTO users (id, name, email, password, roles) VALUES
 (1, 'Admin', 'admin@projecthub.dev', '$2a$10$S0yfyP4L8a8CwF4f6c3B4e8iV6N5wQq2sW7m3Q2x1k4l3f4n8sYwK', 'ROLE_USER');
-- password for admin user above is: admin123
INSERT INTO projects (id, title, description, tags, githubUrl, liveUrl, imageUrl, createdAt) VALUES
 (1, 'Portfolio Website', 'My personal portfolio built with React and MUI', 'react,portfolio', 'https://github.com/you/portfolio', 'https://your-portfolio.com', '', CURRENT_TIMESTAMP());
INSERT INTO posts (id, title, content, slug, published, createdAt, updatedAt) VALUES
 (1, 'Hello ProjectHub', 'This is my first blog on ProjectHub!', 'hello-projecthub', true, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
