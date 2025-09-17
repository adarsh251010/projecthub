FROM node:20-alpine as build
WORKDIR /app
COPY package.json package-lock.json* yarn.lock* pnpm-lock.yaml* ./ 2>/dev/null || true
RUN npm install
COPY . .
RUN npm run build

FROM node:20-alpine
WORKDIR /app
COPY --from=build /app/dist ./dist
RUN npm i -g serve
EXPOSE 5173
CMD ["serve", "-s", "dist", "-l", "5173"]
